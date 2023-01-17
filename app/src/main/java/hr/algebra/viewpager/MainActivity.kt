package hr.algebra.viewpager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager

class MainActivity : AppCompatActivity() {

    private val pages : ArrayList< Fragment > = ArrayList( )
    private val pageTitles : ArrayList< String > = ArrayList( )
    private lateinit var mPager : ViewPager

    override fun onCreate( savedInstanceState: Bundle? ) {
        super.onCreate( savedInstanceState )
        setContentView( R.layout.activity_main )

        pages.add( BlankFragment( ) )
        pages.add( RedFragment( ) )
        pages.add( GreenFragment( ) )

        pageTitles.add( "BLANK" )
        pageTitles.add( "RED" )
        pageTitles.add( "GREEN" )

        mPager = findViewById( R.id.view_pager )
//        mPager.adapter = ScreenSlidePagerAdapter( supportFragmentManager )
        mPager.adapter = MyPagerAdapter( supportFragmentManager )
    }
/*
    private inner class ScreenSlidePagerAdapter( fm : FragmentManager ) : FragmentStatePagerAdapter( fm ) {
        override fun getCount( ): Int {
            return pages.size
        }

        override fun getItem( position: Int ): Fragment = pages[position]

    }
*/
    private inner class MyPagerAdapter( fm : FragmentManager ) : FragmentPagerAdapter( fm ) {
        override fun getCount( ): Int {
            return pages.size
        }

        override fun getItem( position: Int ): Fragment = pages[position]

        override fun getPageTitle( position: Int ): CharSequence? = pageTitles[position]

    }
}
