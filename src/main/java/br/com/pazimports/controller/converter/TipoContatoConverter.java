package br.com.pazimports.controller.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.pazimports.model.TipoContato;
import br.com.pazimports.repositoryy.TipoContatoRepository;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;


@Component
public class TipoContatoConverter implements Converter<Object>{

	@Autowired
	private TipoContatoRepository tipoContatoRepository;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if(value == null || value.isEmpty()) return null;
		try {
			@SuppressWarnings("removal")
			TipoContato tipoContato = tipoContatoRepository.findById(new Integer(value)).orElse(null);
			return tipoContato;
		} catch (Exception e) {
			return null;
		}
	
	}

	
	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value instanceof TipoContato) {
			TipoContato tipoContato = (TipoContato) value;
			return tipoContato.getId().toString();
		}else {
			return null;
		}
	}
	
}
