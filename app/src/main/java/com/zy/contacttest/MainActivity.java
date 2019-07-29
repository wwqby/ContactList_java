package com.zy.contacttest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private SearchView mSearch;
    private RecyclerView mRecyclerView;
    private RecyclerView mRecyclerView2;
    private RecyclerView mRecyclerView3;
    private List<Contact>mContactList;
    private List<String> mLetterList;
    private List<Integer> mletterPosition;
    private List<Contact> searchResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSearch=findViewById(R.id.search);
        mRecyclerView=findViewById(R.id.recyclerView);
        mRecyclerView2=findViewById(R.id.recyclerView2);
        mRecyclerView3=findViewById(R.id.recyclerView3);
        LinearLayoutManager manager=new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        mRecyclerView3.setLayoutManager(manager);
        initContactList();
        initContactRecyclerView();
        initLetterList();
        initLetterRecyclerView();
        initSearchView();
    }

    private void initSearchView() {
        mSearch.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                searchResult=new ArrayList<>();
                if(mRecyclerView.getVisibility()== View.VISIBLE){
                    mRecyclerView.setVisibility(View.GONE);
                    mRecyclerView2.setVisibility(View.GONE);
                }
                String regx="[\\u0391-\\uFFE5]*";
                String newTextRegx="[\\u0391-\\uFFE5]*";
                for (int j=0;j<newText.length();j++){
                    String temp=newTextRegx;
                    newTextRegx=temp+newText.charAt(j)+regx;
                }
                String regx2="[0-9]*";
                String newTextRegx2="[0-9]*";
                for (int j=0;j<newText.length();j++){
                    String temp=newTextRegx2;
                    newTextRegx2=temp+newText.charAt(j)+regx2;
                }
                Log.i("newTextRegx2=", newTextRegx2);
                Log.i("newTextRegx1=", newTextRegx);
                for (Contact data :
                        mContactList) {
                    if (data.getName().matches(newTextRegx)){
                        searchResult.add(data);
                        Log.i("add", data.getName());
                    }else if (data.getPhone().matches(newTextRegx2)){
                        searchResult.add(data);
                        Log.i("add", data.getPhone());
                    }
                }

                ContactAdapter adapter=new ContactAdapter(searchResult);
                mRecyclerView3.setAdapter(adapter);
                return true;
            }
        });
        mSearch.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {
               mRecyclerView.setVisibility(View.VISIBLE);
               mRecyclerView2.setVisibility(View.VISIBLE);
               mRecyclerView3.setVisibility(View.GONE);
                return false;
            }
        });
    }

    private void initLetterRecyclerView() {
        LinearLayoutManager manager=new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        mRecyclerView2.setLayoutManager(manager);
        LetterAdapter adapter=new LetterAdapter(mLetterList,mletterPosition, mRecyclerView);
        mRecyclerView2.setAdapter(adapter);


    }

    private void initLetterList() {
        mLetterList=new ArrayList<>();
        mletterPosition=new ArrayList<>();
        int index=0;
        for (Contact data :
             mContactList) {
            if (!mLetterList.contains(data.getFirstLetter())){
               mLetterList.add(data.getFirstLetter());
               mletterPosition.add(index);
            }
            index++;
        }

    }

    private void initContactRecyclerView() {
        LinearLayoutManager manager=new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        mRecyclerView.setLayoutManager(manager);
        ContactAdapter adapter=new ContactAdapter(mContactList);
        mRecyclerView.setAdapter(adapter);
    }

    private void initContactList() {
        mContactList=new ArrayList<>();
        mContactList.add(new Contact("A","阿黄","13013013011","https://cdn.duitang.com/uploads/item/201508/02/20150802155755_YCynL.thumb.700_0.jpeg"));
        mContactList.add(new Contact("A","阿芳","14014014011","https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=4259300811,497831842&fm=26&gp=0.jpg"));
        mContactList.add(new Contact("B","宝宝","15015015011","https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=4285611627,3487298056&fm=26&gp=0.jpg"));
        mContactList.add(new Contact("D","弟弟","16016016011","https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=1700741544,1951185347&fm=26&gp=0.jpg"));
        mContactList.add(new Contact("G","哥哥","17017017011","https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=3358148341,156066392&fm=26&gp=0.jpg"));
        mContactList.add(new Contact("J","姐姐","18018018011","https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=2402471065,951299553&fm=26&gp=0.jpg"));
        mContactList.add(new Contact("M","妈妈","19019019011","https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=399600612,252901190&fm=26&gp=0.jpg"));
        mContactList.add(new Contact("M","妹妹","12012012011","https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=1466662081,1140396699&fm=26&gp=0.jpg"));
        mContactList.add(new Contact("W","忘了名字","15015015012","https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=3361934473,3725527506&fm=26&gp=0.jpg"));
        mContactList.add(new Contact("X","小强","15015015013","https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=4016536275,4119245052&fm=26&gp=0.jpg"));
    }
}
