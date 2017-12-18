import { Component, OnInit } from '@angular/core';

import { Twitter } from '../shared/model/Twitter';
import { Tweet } from '../shared/model/Tweet';

import { TweetService } from '../shared/service/tweet.service';

@Component({
  selector: 'app-tweet-list',
  templateUrl: './tweet-list.component.html',
  styleUrls: ['./tweet-list.component.scss']
})
export class TweetListComponent implements OnInit {

  tweets: Array<Tweet>;
  loading: boolean;

  constructor(private tweetService: TweetService) {
    this.tweets = [];
    this.loading = false;
  }

  ngOnInit() {
    this.refresh();
  }


  refresh() {
    this.loading = !this.loading;
    this.tweetService.getTweets()
      .subscribe(data => {
        setTimeout(() => {
          this.tweets = data;
          this.loading = !this.loading
        }, 700);
      }, error => {
        setTimeout(() => {
          this.loading = !this.loading
        }, 600);
      });
  }

  parseDate(time) {
    let date = new Date();
    date.setFullYear(time.year, time.monthValue, time.dayOfMonth);
    date.setHours(time.hour, time.minute, time.second);
    return date.toLocaleTimeString() + ' ' + date.toLocaleDateString();
  }
}
