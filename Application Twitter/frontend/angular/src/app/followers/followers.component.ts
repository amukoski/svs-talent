import { Component, OnInit } from '@angular/core';

import { Twitter } from '../shared/model/Twitter';
import { TwitterService } from '../shared/service/twitter.service';

@Component({
  selector: 'app-followers',
  templateUrl: './followers.component.html',
  styleUrls: ['./followers.component.scss']
})
export class FollowersComponent implements OnInit {

  followers: Array<Twitter>;
  constructor(private twitterService: TwitterService) {
    this.followers = [];
  }

  ngOnInit() {
    this.loadTwitters();
  }

  loadTwitters() {
    this.twitterService.getTwitterFollowers()
      .subscribe(data => {
        this.followers = data;
      }, error => {
        console.log('Error', error);
      });
  }
}
