package controllers;

import play.mvc.*;
import play.data.*;
import static play.data.Form.*;
import play.data.validation.Constraints.*;

import views.html.*;

public class Application extends Controller {
	
	/**
     * Describes the kelas form.
     */
    public static class Kelas {
        public String nickname;
        public String kota;
		public Integer banyaknya;
        
    }
	
	public static class Nama {
        public String nama;
        public String lokasi;
		public String kota;
        
    }
	
	// -- Actions
    public static Result index() {
         return ok(
            index.render(form(Kelas.class))
        );
    }
	
	// -- Actions
    public static Result jembatan() {
         return ok(
            jembatan.render(form(Nama.class))
        );
    }
	
	/**
     * Handles the form submission.
     */
    public static Result olahKata() {
        Form<Kelas> form = form(Kelas.class).bindFromRequest();
        if(form.hasErrors()) {
            return badRequest(index.render(form));
        } else {
            Kelas data = form.get();
            return ok(
                kelas.render(data.nickname, data.kota, data.banyaknya)
            );
        }
    }

	public static Result olahJembatan() {
        Form<Nama> form = form(Nama.class).bindFromRequest();
        if(form.hasErrors()) {
            return badRequest(jembatan.render(form));
        } else {
            Nama data = form.get();
            return ok(
                jembatan2.render(data.nama, data.lokasi, data.kota)
            );
        }
    }
}
