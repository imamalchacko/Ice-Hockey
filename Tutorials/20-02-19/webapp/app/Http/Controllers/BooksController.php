<?php

namespace App\Http\Controllers;

use App\Books;
use Illuminate\Http\Request;

class BooksController extends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index()
    {
        $books=Books::all();
        $booksdetails  =Books::all();
        return view('books.index',compact('booksdetails'));
    }

    /**
     * Show the form for creating a new resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function create()
    {
        return view('books.book');
    }

    public function sample()
    {
        return view('books.book');
    }

    /**
     * Store a newly created resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @return \Illuminate\Http\Response
     */
    public function store(Request $request)
    
    {
        $book=new Books([
            'title'=>$request->get('title'),
            'body'=>$request->get('body')
        ]);
        $book->save();
        return redirect('/book/create');
    }
    

    /**
     * Display the specified resource.
     *
     * @param  \App\Books  $books
     * @return \Illuminate\Http\Response
     */
    public function show(Books $books)
    {
        return view('books.book');
    }

    /**
     * Show the form for editing the specified resource.
     *
     * @param  \App\Books  $books
     * @return \Illuminate\Http\Response
     */
    public function edit($id)
    {
       $books=Books::find($id);
       return view('books.edit',compact('books'));
    }

    /**
     * Update the specified resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @param  \App\Books  $books
     * @return \Illuminate\Http\Response
     */
    public function update(Request $request,$id)
    {
        $book=Books::find($id);
        $book->title = $request->get('title');
        $book->body = $request->get('body');
        $book->save();
        return redirect('/book');
    }

    /**
     * Remove the specified resource from storage.
     *
     * @param  \App\Books  $books
     * @return \Illuminate\Http\Response
     */
    public function destroy($id)
    {
        $book=Books::find($id);
        $book->delete();
        return redirect('/book')->with('sucess','Book has deleted sucessfully');
    }
}
