import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../environment/environment';

@Injectable({
  providedIn: 'root'
})
export class RegistrationService {

  url: string = environment.apiUrl;

  constructor(
    public httpClient: HttpClient
  ) { }

  postRegistrationData(postForm: any) {
    return this.httpClient.post(`${this.url}/users/createUser`,postForm);
  }
}