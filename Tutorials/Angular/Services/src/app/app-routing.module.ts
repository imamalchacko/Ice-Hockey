import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ProfileComponent } from './profile/profile.component';
import { HelloWorldComponent } from './hello-world/hello-world.component';

const routes: Routes = [{ path: "login", component: ProfileComponent }, 
{ path: "home", component: HelloWorldComponent }];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
