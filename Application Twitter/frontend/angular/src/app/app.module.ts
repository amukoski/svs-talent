import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgModule, NO_ERRORS_SCHEMA } from '@angular/core';
import { MDBBootstrapModule } from 'angular-bootstrap-md';
import { LoginModule } from './login/login.module';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { ToastModule } from 'ng2-toastr/ng2-toastr';

import { AppRouting } from './app.routing';

import { AppComponent } from './app.component';
import { NavigationComponent } from './navigation/navigation.component';
import { ProfileComponent } from './profile/profile.component';
import { FollowersComponent } from './followers/followers.component';
import { TweetPostComponent } from './tweet-post/tweet-post.component';
import { TweetListComponent } from './tweet-list/tweet-list.component';
import { TwitterSearchComponent } from './twitter-search/twitter-search.component';
import { HomeComponent } from './home/home.component';

import { AuthenticatorService } from './authenticator.service';
import { TweetService } from './shared/service/tweet.service';
import { TwitterService } from './shared/service/twitter.service';

@NgModule({
  declarations: [
    AppComponent,
    NavigationComponent,
    ProfileComponent,
    FollowersComponent,
    TweetPostComponent,
    TweetListComponent,
    TwitterSearchComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    FormsModule,
    HttpModule,
    LoginModule,
    MDBBootstrapModule.forRoot(),
    ToastModule.forRoot(),
    AppRouting
  ],
  providers: [AuthenticatorService, TweetService, TwitterService],
  bootstrap: [AppComponent],
  schemas: [NO_ERRORS_SCHEMA]
})
export class AppModule { }
