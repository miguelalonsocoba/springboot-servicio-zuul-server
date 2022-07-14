package com.formacionbdi.springboot.app.zuul.filters;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

/**
 * Se define el filtro de tipo Pre: Hace referencia al prerut, antes de que el
 * request sea enrutado a un microservicio. Se usa para pasar datos al request
 *
 */
@Component
public class PreTiempoTranscurridoFilter extends ZuulFilter {

	private static Logger log = LoggerFactory.getLogger(PreTiempoTranscurridoFilter.class);

	/*
	 * Valida si se ejecutara el filtro. Se puede realizar cualquier tipo de
	 * validación
	 */
	@Override
	public boolean shouldFilter() {
		return true;
	}

	/*
	 * Se resuelve la logica del filtro.
	 */
	@Override
	public Object run() throws ZuulException {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();

		log.info(String.format("%s request enrutado a %s", request.getMethod(), request.getRequestURL().toString()));

		Long tiempoInicio = System.currentTimeMillis();
		request.setAttribute("tiempoInicio", tiempoInicio);

		return null;
	}

	/*
	 * Se define el tipo de filtro (Pre, Post, Route)
	 */
	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		return 1;
	}

}
