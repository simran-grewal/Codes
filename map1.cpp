#include<iostream>
#include<map>

using namespace std;
int  main()
{
	map<char,int> m;
	m.insert(pair<char,int>('b',100));           //or we can also input by using ----m['b']=100;
	m.insert(pair<char,int>('a',200));
	m.insert(pair<char,int>('c',300));
	map<char,int>::iterator itr;
	for(itr=m.begin();itr!=m.end();itr++)
	{
		cout<<itr->first<<" <=>";
		cout<<itr->second<<" \n";	
	}
}
