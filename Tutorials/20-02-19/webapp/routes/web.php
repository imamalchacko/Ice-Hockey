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

Route::get('/h', function () {
    return view('welcome');
});

Route::get('/home', function () {
    return "<h1>hai MicroManzer</h1>";
});

Route::get('/home/{id}', function ($id) {
    return 'hai, my id is' .$id;
});

// Route::get('/book1', function () {
//     return view('books.index');
// });

Route::resource('/book','BooksController');
Route::resource('/student','StudentsController');
Route::resource('/sample','BooksController@sample');

Route::get('/create', function () {
    return view('books.book');
});

Route::get('/index', 'PagesController@index');
Route::get('/service', 'PagesController@service');
Route::get('/about', 'PagesController@about');


Auth::routes();

Route::get('/home2', 'HomeController@index')->name('home');
