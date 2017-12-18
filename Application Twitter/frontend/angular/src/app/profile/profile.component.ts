import { Component, OnInit } from '@angular/core';

import { Twitter } from '../shared/model/Twitter';
import { TwitterService } from '../shared/service/twitter.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.scss']
})
export class ProfileComponent implements OnInit {

  twitter: Twitter;
  tweets: number;

  constructor(private twitterService: TwitterService) {
    this.twitter = new Twitter();
  }

  ngOnInit() {
    this.twitter = JSON.parse(localStorage.getItem("twitter"));
    this.countTweets();
  }

  countTweets() {
    let id = JSON.parse(localStorage.getItem("twitter")).id;
    this.twitterService.getTwitterTweets(id)
      .subscribe(data => {
        console.log('Success tweets', data);
        this.tweets = data.length;
      }, error => {
        console.log('Error', error);
      });
  }
}
