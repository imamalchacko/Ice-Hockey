import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  user:any;
  check:boolean=false;
  constructor() {
    this.user= {
      name: "amal",
      job: "still studying",
      phone:[9946326678,8606410596],
      email:"amalchacko@mca.ajce.in"
    };

  }
  toggle(){
    this.check=!this.check; 
  }
  ngOnInit() {
  }

}
