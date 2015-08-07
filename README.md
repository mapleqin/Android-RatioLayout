# Android-RatioLayout
This is a specified proportion to the size of the Layout or View support library, with which you can easily set a fixed ratio of the size of the Layout or View, internal adaptive size calculation, completely abandon the code to calculate the size! If you have any questions in the course or suggestions, please send an e-mail to the following e-mail, thank you!

For more information please see <a href='http://devsoulwolf.github.io/ratioLayout'>the website</a>

## Screenshots

![Sample](https://github.com/devsoulwolf/Android-RatioLayout/blob/master/Screenshots/sample1.jpg)
![Sample](https://github.com/devsoulwolf/Android-RatioLayout/blob/master/Screenshots/sample2.jpg)


## Android-RatioLayout with xml code
```xml
		<net.soulwolf.widget.ratiolayout.widget.RatioFrameLayout
			xmlns:soulwolf="http://schemas.android.com/apk/res-auto"
            android:layout_width="match_parent"
            soulwolf:datumRatio="datumWidth"
            soulwolf:widthRatio="16.0"
            soulwolf:heightRatio="9.0"
            android:layout_height="wrap_content">

            <net.soulwolf.widget.ratiolayout.widget.RatioImageView
                android:id="@+id/image2"
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                soulwolf:datumRatio="datumWidth"
                soulwolf:widthRatio="16.0"
                soulwolf:heightRatio="7.0"
                android:scaleType="centerCrop"/>

            <net.soulwolf.widget.ratiolayout.widget.RatioTextView
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                android:textSize="25sp"
                android:textStyle="bold"
                android:gravity="center"
                soulwolf:datumRatio="datumWidth"
                soulwolf:widthRatio="16.0"
                android:background="@color/sample_text"
                soulwolf:heightRatio="7.0"
                android:text="RatioImageView/RatioTextView:16*7"
                android:textColor="@android:color/white"/>

        </net.soulwolf.widget.ratiolayout.widget.RatioFrameLayout>

		<net.soulwolf.widget.ratiolayout.widget.RatioRelativeLayout
			xmlns:soulwolf="http://schemas.android.com/apk/res-auto"
            android:layout_width="match_parent"
            soulwolf:datumRatio="datumWidth"
            soulwolf:widthRatio="15.0"
            android:layout_marginTop="8dp"
            soulwolf:heightRatio="10.0"
            android:layout_height="wrap_content"/>
		
```
## Android-RatioLayout with java code
```java
	RatioFrameLayout ratioFrameLayout = new RatioFrameLayout(context);
	ratioFrameLayout.setRatio(datumRatio,widthRatio,heightRatio);
```

## Attr params  info

|| *attrName* || *Explanation* ||
|| datumRatio || This parameter indicates the ratio is calculated based on Width Or Height! ||
|| widthRatio || This parameter indicates the proportion of the size Width ||
|| heightRatio || This parameter indicates the proportion of the size Height ||

## Implementing View!

 <ul>
   	<li><a href='javascript:void(0)'>RatioAbsoluteLayout</a></li>
	<li><a href='javascript:void(0)'>RatioButton</a></li>
	<li><a href='javascript:void(0)'>RatioCheckBox</a></li>
	<li><a href='javascript:void(0)'>RatioCheckedTextView</a></li>
	<li><a href='javascript:void(0)'>RatioEditText</a></li>
	<li><a href='javascript:void(0)'>RatioFrameLayout</a></li>
	<li><a href='javascript:void(0)'>RatioGridLayout</a></li>
	<li><a href='javascript:void(0)'>RatioImageButton</a></li>
	<li><a href='javascript:void(0)'>RatioImageView</a></li>
	<li><a href='javascript:void(0)'>RatioProgressBar</a></li>
	<li><a href='javascript:void(0)'>RatioRadioButton</a></li>
	<li><a href='javascript:void(0)'>RatioRadioGroup</a></li>
	<li><a href='javascript:void(0)'>RatioRelativeLayout</a></li>
	<li><a href='javascript:void(0)'>RatioSpace</a></li>
	<li><a href='javascript:void(0)'>RatioTableLayout</a></li>
	<li><a href='javascript:void(0)'>RatioTextView</a></li>
 </ul>

## Custom
```java
	public class RatioFrameLayout extends FrameLayout implements RatioMeasureDelegate {

    private RatioLayoutDelegate mRatioLayoutDelegate;

    public RatioFrameLayout(Context context) {
        super(context);
    }

    public RatioFrameLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        mRatioLayoutDelegate = RatioLayoutDelegate.obtain(this, attrs);
    }

    public RatioFrameLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mRatioLayoutDelegate = RatioLayoutDelegate.obtain(this, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public RatioFrameLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        mRatioLayoutDelegate = RatioLayoutDelegate.obtain(this, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if(mRatioLayoutDelegate != null){
            mRatioLayoutDelegate.onMeasure(widthMeasureSpec,heightMeasureSpec);
            widthMeasureSpec = mRatioLayoutDelegate.getWidthMeasureSpec();
            heightMeasureSpec = mRatioLayoutDelegate.getHeightMeasureSpec();
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    public void setDelegateMeasuredDimension(int measuredWidth, int measuredHeight) {
        setMeasuredDimension(measuredWidth, measuredHeight);
    }

    @Override
    public void setRatio(RatioDatumMode mode, float datumWidth, float datumHeight) {
        if(mRatioLayoutDelegate != null){
            mRatioLayoutDelegate.setRatio(mode,datumWidth,datumHeight);
        }
    }

}
```

## Maven
	<dependency>
  	    <groupId>net.soulwolf.widget</groupId>
		<url>https://dl.bintray.com/soulwolf/maven</url>
  	    <artifactId>ratiolayout</artifactId>
  	    <version>1.0.0</version>
	</dependency>
## Gradle
	allprojects {
       repositories {
          jcenter()
       }
	}
	
	compile 'net.soulwolf.widget:ratiolayout:1.0.0'

## Developed by
 Ching Soulwolf - <a href='javascript:'>Ching.Soulwolf@gmail.com</a>


## License
	Copyright 2015 Soulwolf Ching
	Copyright 2015 The Android Open Source Project for Android-RatioLayout
	
	Licensed under the Apache License, Version 2.0 (the "License");
	you may not use this file except in compliance with the License.
	You may obtain a copy of the License at

	    http://www.apache.org/licenses/LICENSE-2.0
	
	Unless required by applicable law or agreed to in writing, software
	distributed under the License is distributed on an "AS IS" BASIS,
	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
	See the License for the specific language governing permissions and
	limitations under the License.
	