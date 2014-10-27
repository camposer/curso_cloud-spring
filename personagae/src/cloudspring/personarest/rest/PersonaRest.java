package cloudspring.personarest.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cloudspring.personarest.model.Persona;
import cloudspring.personarest.service.PersonaService;
import cloudspring.personarest.to.RespuestaRest;

@Controller
@RequestMapping("/personas")
public class PersonaRest {
	@Autowired
	private PersonaService personaService;
	
	@RequestMapping(value="", method=RequestMethod.GET, produces="application/json")
	public @ResponseBody RespuestaRest obtenerPersonas() {
		RespuestaRest respuesta = new RespuestaRest();
		List<Persona> personas = null;
		try {
			personas = personaService.obtenerPersonas();
			respuesta.setStatus(RespuestaRest.Status.SUCCESS);
			respuesta.setData(personas);
		} catch (Exception e) {
			e.printStackTrace();
			respuesta.setStatus(RespuestaRest.Status.ERROR);
			respuesta.setError(e.getMessage());
		}
		return respuesta;
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET, produces="application/json")
	public @ResponseBody RespuestaRest obtenerPersona(@PathVariable Integer id) {
		RespuestaRest respuesta = new RespuestaRest();
		try {
			respuesta.setStatus(RespuestaRest.Status.SUCCESS);
			respuesta.setData(personaService.obtenerPersona(id));
		} catch (Exception e) {
			e.printStackTrace();
			respuesta.setStatus(RespuestaRest.Status.ERROR);
			respuesta.setError(e.getMessage());
		}
		return respuesta;
	}
	
	// TODO: Utilizar clase wrapper para las respuestas!
	@RequestMapping(value="", method=RequestMethod.POST, consumes="application/json", produces="application/json")
	public @ResponseBody RespuestaRest agregarPersona(@RequestBody Persona p) {
		RespuestaRest respuesta = new RespuestaRest();
		try {
			respuesta.setStatus(RespuestaRest.Status.SUCCESS);
			personaService.agregarPersona(p);
		} catch (Exception e) {
			e.printStackTrace();
			respuesta.setStatus(RespuestaRest.Status.ERROR);
			respuesta.setError(e.getMessage());
		}
		return respuesta;
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT, consumes="application/json")
	public @ResponseBody RespuestaRest modificarPersona(@RequestBody Persona p, @PathVariable Long id) {
		RespuestaRest respuesta = new RespuestaRest();
		try {
			respuesta.setStatus(RespuestaRest.Status.SUCCESS);
			p.setId(id);
			personaService.modificarPersona(p);
		} catch (Exception e) {
			e.printStackTrace();
			respuesta.setStatus(RespuestaRest.Status.ERROR);
			respuesta.setError(e.getMessage());
		}
		return respuesta;
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public @ResponseBody RespuestaRest eliminarPersona(@PathVariable Integer id) {
		RespuestaRest respuesta = new RespuestaRest();
		try {
			respuesta.setStatus(RespuestaRest.Status.SUCCESS);
			personaService.eliminarPersona(id);
		} catch (Exception e) {
			e.printStackTrace();
			respuesta.setStatus(RespuestaRest.Status.ERROR);
			respuesta.setError(e.getMessage());
		}
		return respuesta;
	}
	
	
	
}
