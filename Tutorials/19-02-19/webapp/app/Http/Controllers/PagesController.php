<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;

class PagesController extends Controller
{
    public function index()
    {
        $title="jubin";
        $name="jub";
        // return view('pages.index',compact('title'));
        return view('pages.index')->with('nam',$name);
    }
    public function service()
    {
        return view('pages.service');
    }
    public function about()
    {
        return view('pages.about');
    }
}
