import { Component, OnInit, ViewChild } from '@angular/core';
import { FormGroup, NgForm, FormControl, FormArray, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { RegistrationService } from './registration.service';
import { RegistrationForm } from './registration.form';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {
  regForm!: FormGroup;
  passwordMatch: boolean = true;

  constructor(
    private router: Router,
    private registrationService: RegistrationService
  ){}

  ngOnInit() {
    this.regForm = new FormGroup({
      username: new FormControl(null, Validators.required),
      password: new FormControl(null, [Validators.required, Validators.pattern(/^(?=[^A-Z]*[A-Z])(?=[^a-z]*[a-z])(?=\D*\d).{8,}$/)]),
      confirmPassword: new FormControl({value: null, disabled: true}, Validators.required),
      securityQuestion: new FormControl("1"),
      securityAnswer: new FormControl(null, Validators.required)
    });
  }

  onRegister(){
    let obj: RegistrationForm = new RegistrationForm(
      this.regForm.value.username,
      this.regForm.value.password,
      'N',
      this.regForm.value.securityQuestion,
      this.regForm.value.securityAnswer
    );
    
    this.registrationService.postRegistrationData(obj).subscribe(response => {
      console.log('response',response);
    })
  }

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
