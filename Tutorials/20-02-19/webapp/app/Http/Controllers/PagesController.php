<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;

class PagesController extends Controller
{
    public function index(){
        $name="Sachin";

        //return view('pages.index',compact('name'));
        return view('pages.index')->with('title',$name);
    }
    public function service(){
        return view('pages.service');
    }
    public function about(){
        return view('pages.about');
    }
}
