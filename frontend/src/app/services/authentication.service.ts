import { Injectable } from '@angular/core';
import axios from 'axios';
import { environment } from './../environment/environment';

@Injectable({
  providedIn: 'root',
})
export class AuthenticationService {
  constructor() {}

  async authenticate(username: string, password: string) {
    try {
      const response = await axios.post(`${environment.apiUrl}/authenticate`, {
        username: username,
        password: password,
      });
      console.log(`RESPONSE DATA: ${JSON.stringify(response.data)}`);
      if (response.data != null) {
        sessionStorage.setItem('username', username);
        sessionStorage.setItem('sessionid', response.data.sessionid);
        return true;
      } else {
        return false;
      }
    } catch (error) {
      if (axios.isAxiosError(error)) {
        if (error.response?.status == 401) {
          console.log(error.response?.status);
        }
      } else {
        console.error(
          `Error while authenticating the user with username ${username}`
        );
      }
      return false;
    }
  }

  isUserLoggedIn() {
    let user = sessionStorage.getItem('username');
    console.log(!(user == null));
    return !(user == null);
  }

  logout() {
    sessionStorage.removeItem('username');
    sessionStorage.removeItem('sessionid');
  }
}
