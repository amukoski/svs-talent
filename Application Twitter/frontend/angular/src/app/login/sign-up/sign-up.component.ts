import { Component, OnInit, ViewContainerRef } from '@angular/core';
import { Router } from '@angular/router';
import { ToastsManager } from 'ng2-toastr/ng2-toastr';

import { Twitter } from '../../shared/model/Twitter';

import { LoginService } from '../../shared/service/login.service';

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.scss']
})
export class SignUpComponent implements OnInit {

  twitter: Twitter = new Twitter();
  loading: boolean = false;

  constructor(
    private loginService: LoginService,
    private router: Router,
    public toastr: ToastsManager,
    public vRef: ViewContainerRef
  ) { this.toastr.setRootViewContainerRef(vRef); }

  ngOnInit() {
  }

  signUp() {
    this.loading = !this.loading;

    this.loginService.signUp(this.twitter)
      .subscribe(data => {
        this.toastr.success('Twitter created!', 'Success!');
        setTimeout(() => {
          this.loading = !this.loading;
          this.router.navigate(['/login/sign-in']);
        }, 1000);
      }, error => {
        setTimeout(() => {
          this.toastr.error('Email exists or server error!', 'Error!');
          this.loading = !this.loading;
        }, 600);
      });
  }


}
