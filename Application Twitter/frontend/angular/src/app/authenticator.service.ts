import { Injectable } from '@angular/core';
import { Router, CanActivate } from '@angular/router';

@Injectable()
export class AuthenticatorService implements CanActivate {

  private authenticated: boolean;

  constructor(private router: Router) {
    this.authenticated = false;
  }

  canActivate(): boolean {
    if (!this.authenticated) {
      this.router.navigate(['login']);
      return false;
    }
    return true;
  }

  isAuthenticated(): boolean {
    return this.authenticated;
  }

  setAuthenticated(state: boolean) {
    this.authenticated = state;
  }
}
