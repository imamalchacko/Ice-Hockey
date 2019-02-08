import { Component, OnInit } from '@angular/core';
import { student } from '../student';
import { NgForm } from '@angular/forms';
import { ServiceOneService } from '../service-one.service';

@Component({
  selector: 'app-apply',
  templateUrl: './apply.component.html',
  styleUrls: ['./apply.component.css']
})
export class ApplyComponent implements OnInit {
  student = new student();
  isRegistered=false;

  constructor( private applyService:ServiceOneService) { 

  }

  apply(f:NgForm){
    this.applyService.store(this.student).subscribe(
      data=>{
        this.isRegistered=true;
        console.log("Registration Succesfull");
        f.reset();        
      },
      err=>{
        this.isRegistered=false;
        console.log("Reg failed");
      }
    )
  }
  ngOnInit() {
    
  }

}
