import { Component, OnInit, ViewContainerRef } from '@angular/core';
import { ToastsManager } from 'ng2-toastr/ng2-toastr';

import { Twitter } from '../shared/model/Twitter';
import { Tweet } from '../shared/model/Tweet';

import { TweetService } from '../shared/service/tweet.service';

@Component({
  selector: 'app-tweet-post',
  templateUrl: './tweet-post.component.html',
  styleUrls: ['./tweet-post.component.scss']
})
export class TweetPostComponent implements OnInit {

  tweet: Tweet;
  twitter: Twitter;

  constructor(private tweetService: TweetService, public toastr: ToastsManager, public vcr: ViewContainerRef) {
    this.toastr.setRootViewContainerRef(vcr);
    this.twitter = new Twitter();
    this.tweet = new Tweet();
  }

  ngOnInit() {
    this.twitter = JSON.parse(localStorage.getItem("twitter"));
    this.tweet.twitter = this.twitter;
  }

  postTweet() {

    this.tweetService.postTweet(this.tweet)
      .subscribe(data => {
        setTimeout(() => {
          this.toastr.info('Tweeting.....');
          this.tweet.text = "";
        }, 400);
      }, error => {
        this.toastr.error('Tweet cannot be saved or server error', 'Error!');
        setTimeout(() => {
          this.tweet.text = "";
        }, 400);
      });
  }
}
