import { NgModule } from '@angular/core';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MDBBootstrapModule } from 'angular-bootstrap-md';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { ToastModule } from 'ng2-toastr/ng2-toastr';

import { LoginComponent } from './login.component';
import { SignInComponent } from './sign-in/sign-in.component';
import { SignUpComponent } from './sign-up/sign-up.component';

import { LoginRouting } from './login.routing';

import { AuthenticatorService } from '../authenticator.service';
import { LoginService } from '../shared/service/login.service';

@NgModule({
  imports: [
    CommonModule,
    BrowserAnimationsModule,
    FormsModule,
    HttpModule,
    LoginRouting,
    MDBBootstrapModule.forRoot(),
    ToastModule.forRoot()
  ],
  declarations: [
    SignInComponent,
    SignUpComponent,
    LoginComponent
  ],
  providers: [LoginService, AuthenticatorService]
})
export class LoginModule { }
