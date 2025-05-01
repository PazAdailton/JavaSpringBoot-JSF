package br.com.pazimports.controller.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.pazimports.model.Estado;
import br.com.pazimports.repositoryy.EstadoRepository;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;

@Component
public class EstadoConverter implements Converter<Object>{

	@Autowired
	private EstadoRepository estadoRepository;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if(value.isEmpty()) return null;
		try {
			@SuppressWarnings("removal")
			Estado estado = estadoRepository.findOne(new Integer(value));
			return estado;
		} catch (Exception e) {
			return null;
		}
	
	}

	
	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value instanceof Estado) {
			Estado estado = (Estado) value;
			return estado.getId().toString();
		}else {
			return null;
		}
	}
	
}
