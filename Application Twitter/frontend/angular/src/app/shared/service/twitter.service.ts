import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs/Rx';

import { Twitter } from '../model/Twitter';
import { Tweet } from '../model/Tweet';

import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';

@Injectable()
export class TwitterService {

  url: string = "http://localhost:8080/twitters";

  constructor(private http: Http) { }

  getTwitters() {
    return this.http.get(this.url)
      .map((res: Response) => res.json())
      .catch((err: Response) => {
        return Observable.throw(err);
      });
  }

  getTwitterFollowers() {
    return this.http.get(this.url + "/followers")
      .map((res: Response) => res.json())
      .catch((err: Response) => {
        return Observable.throw(err);
      });
  }

  getTwitterFollowing() {
    return this.http.get(this.url + "/followings")
      .map((res: Response) => res.json())
      .catch((err: Response) => {
        return Observable.throw(err);
      });
  }

  getTwittersByEmailLike(email) {
    return this.http.get(this.url + "/email-search/" + email)
      .map((res: Response) => res.json())
      .catch((err: Response) => {
        return Observable.throw(err);
      });
  }

  getTwitterTweets(twitterId: number) {
    return this.http.get(this.url + "/" + twitterId + "/tweets")
      .map((res: Response) => res.json())
      .catch((err: Response) => {
        return Observable.throw(err);
      });
  }

  followOtherTwitter(twitterId: number) {
    return this.http.post(this.url + "/follow/" + twitterId, {})
      .map((res: Response) => res.json())
      .catch((err: Response) => {
        return Observable.throw(err);
      });
  }
}
