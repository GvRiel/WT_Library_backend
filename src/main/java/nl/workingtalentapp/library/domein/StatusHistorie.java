package nl.workingtalentapp.library.domein;

import java.time.LocalDateTime;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class StatusHistorie {
	
@Id
@GeneratedValue(strategy=GenerationType.AUTO)

long id;

int status_id;

int copy_id;

String title;

boolean admin_modif;

LocalDateTime timestamp;

int user_id;

String status_before;

String status_after;

}
