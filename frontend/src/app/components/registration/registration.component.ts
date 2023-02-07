import { Component, OnInit, ViewChild } from '@angular/core';
import { FormGroup, NgForm, FormControl, FormArray, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {
  regForm!: FormGroup;
  passwordMatch: boolean = true;

  constructor(
    private router: Router
  ){}

  ngOnInit(): void {
    this.regForm = new FormGroup({
      username: new FormControl(null, Validators.required),
      password: new FormControl(null, [Validators.required, Validators.pattern(/^(?=[^A-Z]*[A-Z])(?=[^a-z]*[a-z])(?=\D*\d).{8,}$/)]),
      confirmPassword: new FormControl({value: null, disabled: true}, Validators.required),
      securityQuestion: new FormControl("1"),
      securityAnswer: new FormControl(null, Validators.required)
    });
  }

  onRegister(){}

  confirmPasswordCheck(e: any){
    this.passwordMatch = (this.regForm.get('password')?.value == e) ? true : false;
  }

  onChangePassword(e: any){
    if(e != ''){
      this.regForm.get('confirmPassword')?.enable();
    }else{
      this.regForm.get('confirmPassword')?.setValue('');
      this.regForm.get('confirmPassword')?.disable();
    }
  }

  openLogin() {
    this.router.navigate(["login"]);
  }
}
