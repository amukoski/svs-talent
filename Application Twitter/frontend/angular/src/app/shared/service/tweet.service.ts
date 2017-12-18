import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs/Rx';

import { Twitter } from '../model/Twitter';
import { Tweet } from '../model/Tweet';

import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';

@Injectable()
export class TweetService {

  url: string = "http://localhost:8080/tweets";

  constructor(private http: Http) { }

  getTweets() {
    return this.http.get(this.url + "/twitters/following?sort=time,desc")
      .map((res: Response) => res.json())
      .catch((err: Response) => {
        return Observable.throw(err);
      });
  }

  postTweet(tweet: Tweet) {
    return this.http.post(this.url, tweet)
      .map((res: Response) => res.json())
      .catch((err: Response) => {
        return Observable.throw(err);
      });
  }

}
