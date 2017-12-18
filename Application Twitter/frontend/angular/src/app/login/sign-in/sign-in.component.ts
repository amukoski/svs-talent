import { Component, OnInit, ViewContainerRef } from '@angular/core';
import { Router } from '@angular/router';
import { ToastsManager } from 'ng2-toastr/ng2-toastr';

import { Twitter } from '../../shared/model/Twitter';

import { LoginService } from '../../shared/service/login.service';
import { AuthenticatorService } from '../../authenticator.service';

@Component({
  selector: 'app-sign-in',
  templateUrl: './sign-in.component.html',
  styleUrls: ['./sign-in.component.scss']
})
export class SignInComponent implements OnInit {

  twitter: Twitter = new Twitter();
  loading: boolean = false;

  constructor(
    private loginService: LoginService,
    private authenticator: AuthenticatorService,
    private router: Router,
    public toastr: ToastsManager,
    public vRef: ViewContainerRef
  ) { this.toastr.setRootViewContainerRef(vRef); }

  ngOnInit() {
  }

  signIn() {
    this.loading = !this.loading;

    this.loginService.signIn(this.twitter)
      .subscribe(data => {
        this.authenticator.setAuthenticated(true);
        localStorage.setItem("twitter", JSON.stringify(data));
        this.toastr.success('You are now signed in!', 'Success!');

        setTimeout(() => {
          this.loading = !this.loading;
          this.router.navigate(['/home']);
        }, 1000);
      }, error => {
        setTimeout(() => {
          this.toastr.error('Invalid email or server error!', 'Error!');
          this.loading = !this.loading;
        }, 600);
      });

  }
}
