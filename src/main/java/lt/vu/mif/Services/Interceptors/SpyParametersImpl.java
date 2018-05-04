package lt.vu.mif.Services.Interceptors;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Interceptor
@SpyParameters
public class SpyParametersImpl {

    @AroundInvoke
    public Object writeToConsole(InvocationContext context) throws Exception {
        for (Object argument : context.getParameters()) {
            System.out.println(argument);
        }
        return context.proceed();
    }
}
