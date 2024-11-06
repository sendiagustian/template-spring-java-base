package id.sendistudio.spring.base.app.middlewares;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.servlet.HandlerInterceptor;

import id.sendistudio.spring.base.app.utils.JwtTokenUtil;
import id.sendistudio.spring.base.constants.ExcludeEndpoint;
import id.sendistudio.spring.base.data.views.UserView;
import id.sendistudio.spring.base.repositories.UserRepository;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@SecurityScheme(name = "X-API-TOKEN", type = SecuritySchemeType.APIKEY, in = SecuritySchemeIn.HEADER)
public class TokenInterceptorMiddleware implements HandlerInterceptor {

    @Autowired
    JwtTokenUtil jwt;

    @Autowired
    ExcludeEndpoint excludeEndpoint;

    @Autowired
    UserRepository userRepository;

    @Override
    public boolean preHandle(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response,
            @NonNull Object handler) throws Exception {

        String requestURI = request.getRequestURI();
        String tokenHeader = request.getHeader("X-API-TOKEN");

        List<String> tokenExcludes = excludeEndpoint.getTokenExcludes();
        if (!tokenExcludes.stream().anyMatch(requestURI::startsWith)) {
            if (tokenHeader == null || tokenHeader.isEmpty()) {
                throw new MissingServletRequestParameterException("X-API-TOKEN", "Header");
            }

            String username = jwt.extractClaim(tokenHeader, claims -> claims.get("sub", String.class)).orElse(null);

            if (username == null) {
                throw new Exception("Unauthorized");
            } else {

                Boolean tokenExpired = jwt.isTokenExpired(tokenHeader);

                if (tokenExpired) {
                    throw new Exception("Token Expired");
                } else {
                    UserView user = userRepository.getByToken(tokenHeader).orElse(null);

                    if (user == null) {
                        throw new Exception("Token Header not valid or user not found");
                    }
                }

            }

        }

        return true;
    }
}
