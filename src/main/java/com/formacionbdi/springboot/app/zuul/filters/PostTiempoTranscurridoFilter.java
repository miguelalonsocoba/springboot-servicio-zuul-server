package com.formacionbdi.springboot.app.zuul.filters;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

/**
 * Se define el filtro de tipo Post: Hace referencia al prerut, antes de que el
 * request sea enrutado a un microservicio. Se usa para pasar datos al request
 *
 */
@Component
public class PostTiempoTranscurridoFilter extends ZuulFilter {

	private static Logger log = LoggerFactory.getLogger(PostTiempoTranscurridoFilter.class);

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

		log.info("Entrando a post filter");

		Long tiempoInicio = (Long) request.getAttribute("tiempoInicio");
		Long tiempoFinal = System.currentTimeMillis();
		Long tiempoTranscurrido = tiempoFinal - tiempoInicio;

		log.info(String.format("Tiempo transcurrido en segundos %s seg.", tiempoTranscurrido.doubleValue() / 1000.00));
		log.info(String.format("Tiempo transcurrido en milisegundos %s ms.", tiempoTranscurrido));
		return null;
	}

	/*
	 * Se define el tipo de filtro (Pre, Post, Route)
	 */
	@Override
	public String filterType() {
		return "post";
	}

	@Override
	public int filterOrder() {
		return 1;
	}

}
