import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { UserService } from './user.service';
import { Panier } from '../Model/Panier';
import { Item } from '../Model/Item';

@Injectable({
  providedIn: 'root'
})
export class PanierService {

  constructor(public http : HttpClient, public user : UserService) { }

  serviceURL = 'http://localhost:3050/panier';

  addPanier(item : Item) {
	this.http.post<Panier>(this.serviceURL + '/add' + this.user.currentUser?.panier.id, item).subscribe(
	  (data) => {
		if (this.user.currentUser) {
		  this.user.currentUser.panier = data;
		}
	  }
	);
  }

  removePanier(item : Item) {
	this.http.post<Panier>(this.serviceURL + '/remove' + this.user.currentUser?.panier.id, item).subscribe(
	  (data) => {
		if (this.user.currentUser) {
		  this.user.currentUser.panier = data;
		}
	}
	);
  }
}
