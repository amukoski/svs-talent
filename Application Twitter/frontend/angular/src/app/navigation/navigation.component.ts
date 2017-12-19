import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { AuthenticatorService } from '../authenticator.service';
import { LoginService } from '../shared/service/login.service';

@Component({
  selector: 'app-navigation',
  templateUrl: './navigation.component.html',
  styleUrls: ['./navigation.component.css']
})
export class NavigationComponent implements OnInit {

  constructor(
    public auth: AuthenticatorService,
    private loginService: LoginService,
    private router: Router
  ) { }

  ngOnInit() {
  }

  signOut() {
    console.log('Signing out..');
    this.loginService.signOut()
      .subscribe(data => {
        this.auth.setAuthenticated(false);
        localStorage.removeItem("twitter");

        this.router.navigate(['/login']);

      }, error => {
        console.log('Error', error);
        // ShowStatus
      });

  }
}
