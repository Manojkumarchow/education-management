import { Component, OnInit, ViewChild } from '@angular/core';
import { Form, NgForm } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { AuthenticationService } from 'src/app/services/authentication.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {
  @ViewChild('myForm') courseForm: NgForm | undefined;

  invalidLogin = false;

  constructor(
    private router: Router,
    private loginService: AuthenticationService
  ) {}

  ngOnInit() {}

  onSubmit(form: NgForm) {
    console.log('form', form.value);
    this.checkLogin(form.value.username, form.value.password);
  }

  openRegistration() {
    this.router.navigate(['registration']);
  }

  async checkLogin(username: string, password: string) {
    if (await this.loginService.authenticate(username, password)) {
      // TODO: should route to HOME PAGE
      this.router.navigate(['registration']);
    } else {
      this.invalidLogin = true;
    }
  }
}
