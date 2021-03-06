package com.springland365.zuulsvc.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class TrackingFilter extends ZuulFilter {
    private static final int FILTER_ORDER = 1;
    private static final boolean SHOULD_FILTER = true ;
    private static final Logger logger = LoggerFactory.getLogger(TrackingFilter.class);

    @Autowired
    FilterUtils filterUtils;


    @Override
    public String filterType() {
        return FilterUtils.PRE_FILTER_TYPE;
    }

    @Override
    public int filterOrder() {
        return FILTER_ORDER;
    }

    @Override
    public boolean shouldFilter() {
        return SHOULD_FILTER;
    }

    private boolean isCorrelatinIdPresent()
    {
        if(filterUtils.getCorrelationId() != null)
        {
            return true ;
        }
        return false ;
    }

    private String generateCorrelationId()
    {
        return UUID.randomUUID().toString();
    }
    @Override
    public Object run() throws ZuulException {
        if(isCorrelatinIdPresent())
        {
            logger.info("tmx-correlation-id found in tracking filter: {}.");
        }
        else
        {
            filterUtils.setCorrelationId(generateCorrelationId());
        }
        RequestContext ctx =
                RequestContext.getCurrentContext();
        logger.info("Processing incoming request for {}.",
                ctx.getRequest().getRequestURI());

        logger.info("Request Correlation Id " +  filterUtils.getCorrelationId());
        return null;
    }
}
