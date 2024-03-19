import { Component } from '@angular/core';
import { LogsDTO } from '../../Model/logsDTO';
import { FormBuilder, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { UserService } from '../../Service/user.service';

@Component({
  selector: 'app-inscription',
  standalone: true,
  imports: [FormsModule, ReactiveFormsModule],
  templateUrl: './inscription.component.html',
  styleUrl: './inscription.component.css'
})
export class InscriptionComponent {
	constructor(public user: UserService, public fb : FormBuilder) { }

	public connectionForm = this.fb.group({
		name: ['', [Validators.required]],
		password: ['', [Validators.required]]
	});

	onSubmit() {
		console.log(this.connectionForm.value);

		let user : LogsDTO = {
			name: this.connectionForm.value.name,
			password: this.connectionForm.value.password
		}

		this.user.connectUser(user);
	}
}
