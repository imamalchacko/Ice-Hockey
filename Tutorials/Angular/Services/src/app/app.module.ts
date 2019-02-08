import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ProfileComponent } from './profile/profile.component';
import { ApplyComponent } from './apply/apply.component';
import { ServiceOneService } from './service-one.service';

@NgModule({
  declarations: [
    AppComponent,
    ProfileComponent,
    ApplyComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [
    ServiceOneService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
