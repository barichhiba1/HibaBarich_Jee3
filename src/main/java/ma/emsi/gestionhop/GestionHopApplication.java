package ma.emsi.gestionhop;

import ma.emsi.gestionhop.entities.Patient;
import ma.emsi.gestionhop.repository.PatientRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class GestionHopApplication implements CommandLineRunner {

	@Autowired
	private PatientRepos PatientR;
	public static void main(String[] args) {

		SpringApplication.run(GestionHopApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception
	{

		//Creation d'un Patient
		//1
		Patient pat=new Patient();
		pat.setNom("Arij");
		pat.setDateNaissance(new Date());
		pat.setMalade(false);
		pat.setScore(23);


		//2
		Patient pat2= new Patient(null,"Amine",new Date(),false,266);

		//3
		Patient pat3= Patient.builder()
				.nom("Imane")
				.dateNaissance(new Date())
				.score(59)
				.malade(true)
				.build();

		PatientR.save(pat);
		PatientR.save(pat2);
		PatientR.save(pat3);


		Patient pat4= new Patient(null,"Mehdi",new Date(),false,266);
		Patient pat5= new Patient(null,"Hiba",new Date(),false,266);
		Patient pat6= new Patient(null,"Leila",new Date(),false,266);
		Patient pat7= new Patient(null,"Imad",new Date(),false,266);

		PatientR.save(pat4);
		PatientR.save(pat5);
		PatientR.save(pat6);
		PatientR.save(pat7);

	}
}
