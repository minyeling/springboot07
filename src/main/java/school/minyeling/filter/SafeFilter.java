package school.minyeling.filter;

import org.springframework.beans.factory.annotation.Autowired;
import school.minyeling.domain.Safe;
import school.minyeling.service.SafeService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter
public class SafeFilter implements Filter {

    @Autowired
    SafeService safeService;

    Safe safe=new Safe();
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("》》》 FilterName = "+filterConfig.getFilterName());
        safe.setFilterName(filterConfig.getFilterName());
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("》》》 RemoteHost = "+request.getRemoteHost());
        System.out.println("》》》 RemoteAddr = "+request.getRemoteAddr());
        safe.setRemoteAddr(request.getRemoteHost());
        safe.setRemoteHost(request.getRemoteAddr());

        safeService.insertOne(safe);
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
