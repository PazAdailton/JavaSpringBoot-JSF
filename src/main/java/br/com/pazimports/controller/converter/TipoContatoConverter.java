package br.com.pazimports.controller.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.pazimports.model.TipoContato;
import br.com.pazimports.repositoryy.TipoContatoRepository;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

@FacesConverter(forClass = TipoContato.class, managed = true)
@Component
public class TipoContatoConverter implements Converter<Object> {
	
	@Autowired
	private TipoContatoRepository tipoContatoRepositoty;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if(value.isEmpty()) return null;
		try {
			@SuppressWarnings("removal")
			TipoContato tContato = tipoContatoRepositoty.findOne(new Integer(value));
			return tContato;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value instanceof TipoContato) {
			TipoContato tContato = (TipoContato) value;
			return tContato.getId().toString();
		}
		return null;
	}

}
