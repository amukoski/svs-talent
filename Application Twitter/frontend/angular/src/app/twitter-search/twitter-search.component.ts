import { Component, OnInit } from '@angular/core';

import { Twitter } from '../shared/model/Twitter';
import { TwitterService } from '../shared/service/twitter.service';

@Component({
  selector: 'app-twitter-search',
  templateUrl: './twitter-search.component.html',
  styleUrls: ['./twitter-search.component.scss']
})
export class TwitterSearchComponent implements OnInit {

  twitters: Array<Twitter>;
  following: Array<Twitter>;
  twittersState: Array<Twitter>;
  search: string;

  constructor(private twitterService: TwitterService) {
    this.twitters = [];
    this.following = [];
    this.twittersState = [];
  }

  ngOnInit() {
    this.loadTwitters();
    this.loadFollowings();
  }


  loadTwitters() {
    this.twitterService.getTwitters()
      .subscribe(data => {
        console.log('Success', data);
        this.twitters = this.twittersState = data;

        let myId = JSON.parse(localStorage.getItem("twitter")).id;
        let index = this.twitters.findIndex((el) => el.id === myId);

        this.twitters.splice(index, 1);
      }, error => {
        console.log('Error', error);
      });
  }

  loadFollowings() {
    this.twitterService.getTwitterFollowing()
      .subscribe(data => {
        console.log('Success', data);
        this.following = data;
      }, error => {
        console.log('Error', error);
      });
  }

  checkTwitterId(twitterId) {
    return this.following.findIndex((el) => el.id === twitterId) > -1;
  }

  follow(twitterId) {
    this.twitterService.followOtherTwitter(twitterId)
      .subscribe(data => {
        console.log('Success', data);
        this.loadFollowings();
      }, error => {
        console.log('Error', error);
      });
  }

  searchEmail(inputText) {
    this.search = inputText;
    if (this.search.length === 0) {
      this.twitters = this.twittersState;
    } else {
      this.twitterService.getTwittersByEmailLike(this.search)
        .subscribe(data => {
          this.twitters = data;
        }, error => {
          this.twitters = this.twittersState;
        });
    }
  }
}
