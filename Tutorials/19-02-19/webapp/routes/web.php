<?php

/*
|--------------------------------------------------------------------------
| Web Routes
|--------------------------------------------------------------------------
|
| Here is where you can register web routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| contains the "web" middleware group. Now create something great!
|
*/

Route::get('/', function () {
    return view('welcome');
});
Route::get('/hai', function () {
    return "<h1>HAI Jubin</h1>";
});
Route::get('/user/{id}', function ($id) {
    return 'hai your Id is '.$id;
});
Route::get('/about', function () {
    return view('pages.about');

});
Route::get('/index', 'PagesController@index');
Route::get('/service', 'PagesController@service');
Route::get('/about', 'PagesController@about');
Route::get('/sample', 'BooksController@sample');
Route::resource('/book','BooksController');
Route::resource('/student','StudentsController');
Route::get('/create', function () {
    return view('Book.book');

});
Auth::routes();

Route::get('/home', 'HomeController@index')->name('home');
 