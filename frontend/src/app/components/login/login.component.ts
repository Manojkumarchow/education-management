import { Component, OnInit, ViewChild } from '@angular/core';
import { Form, NgForm } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent implements OnInit {
	@ViewChild('myForm') courseForm: NgForm | undefined;

  constructor(
    private router: Router
  ){}

  ngOnInit(){}

  onSubmit(form: NgForm) {
    console.log('form',form);
  }

  openRegistration(){
    this.router.navigate(["registration"]);
  }
}
