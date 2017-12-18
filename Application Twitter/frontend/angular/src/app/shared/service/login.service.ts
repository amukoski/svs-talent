import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs/Rx';

import { Twitter } from '../model/Twitter';

import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';

@Injectable()
export class LoginService {

  url: string = "http://localhost:8080/";

  constructor(private http: Http) { }

  signUp(twitter: Twitter) {
    return this.http.post(this.url + 'sign-up', twitter)
      .map((res: Response) => res.json())
      .catch((err: Response) => {
        return Observable.throw(err);
      });
  }

  signIn(twitter: Twitter) {
    return this.http.post(this.url + 'sign-in', twitter)
      .map((res: Response) => res.json())
      .catch((err: Response) => {
        return Observable.throw(err);
      });
  }

  signOut() {
    return this.http.get(this.url + 'sign-out');
  }
}
