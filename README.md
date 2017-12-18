# Android-RatioLayout [![Build Status](https://travis-ci.org/amphiaraus/Android-RatioLayout.svg)](https://travis-ci.org/amphiaraus/Android-RatioLayout) [ ![Download](https://api.bintray.com/packages/soulwolf/maven/ratiolayout/images/download.svg) ](https://bintray.com/soulwolf/maven/ratiolayout/_latestVersion)
This is a specified proportion to the size of the Layout or View support library, with which you can easily set a fixed ratio of the size of the Layout or View, internal adaptive size calculation, completely abandon the code to calculate the size! If you have any questions in the course or suggestions, please send an e-mail to the following e-mail, thank you!

For more information please see <a href='http://amphiaraus.org/Android-RatioLayout'>the website</a>

## Screenshots

![Sample](https://raw.githubusercontent.com/amphiaraus/Android-RatioLayout/master/Screenshots/sample-1.jpg)
![Sample](https://raw.githubusercontent.com/amphiaraus/Android-RatioLayout/master/Screenshots/sample-2.jpg)


## Android-RatioLayout with xml code
```xml
<net.soulwolf.widget.ratiolayout.widget.RatioFrameLayout
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    app:datumRatio="datumWidth"
    app:widthRatio="16.0"
    app:heightRatio="9.0"
    android:layout_height="wrap_content">

    <net.soulwolf.widget.ratiolayout.widget.RatioImageView
        android:id="@+id/image2"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        app:datumRatio="datumWidth"
        app:widthRatio="16.0"
        app:heightRatio="7.0"
        android:scaleType="centerCrop"/>

    <net.soulwolf.widget.ratiolayout.widget.RatioTextView
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:textSize="25sp"
        android:textStyle="bold"
        android:gravity="center"
        app:datumRatio="datumWidth"
        app:widthRatio="16.0"
        android:background="@color/sample_text"
        app:heightRatio="7.0"
        android:text="RatioImageView/RatioTextView:16*7"
        android:textColor="@android:color/white"/>

</net.soulwolf.widget.ratiolayout.widget.RatioFrameLayout>

<LinearLayout
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:layout_marginTop="8dp"
    android:orientation="horizontal">

    <net.soulwolf.widget.ratiolayout.widget.RatioTextView
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:layout_weight="1"
        android:background="@color/sample_primary"
        android:gravity="center"
        android:text="Square"
        android:textColor="@android:color/white"
        android:textSize="20sp"
        android:textStyle="bold"
        app:layoutSquare="true"/>

    <net.soulwolf.widget.ratiolayout.widget.RatioView
        android:layout_width="15dp"
        android:layout_height="wrap_content"
        app:heightRatio="1"
        app:widthRatio="1"/>

    <net.soulwolf.widget.ratiolayout.widget.RatioTextView
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:layout_weight="1"
        android:background="@color/sample_primary"
        android:gravity="center"
        android:text="AspectRatio:1.0"
        android:textColor="@android:color/white"
        android:textSize="20sp"
        android:textStyle="bold"
        app:layoutAspectRatio="1"/>

</LinearLayout>

<net.soulwolf.widget.ratiolayout.widget.RatioRelativeLayout
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    app:datumRatio="datumWidth"
    app:widthRatio="15.0"
    app:layout_marginTop="8dp"
    app:heightRatio="10.0"
    app:layout_height="wrap_content"/>
		
```
## Android-RatioLayout with java code
```java
RatioFrameLayout ratioFrameLayout = new RatioFrameLayout(context);
ratioFrameLayout.setRatio(datumRatio,widthRatio,heightRatio);
ratioFrameLayout.setSquare(square);
ratioFrameLayout.setAspectRatio(aspectRatio);
```

## Attr params  info

<table>
	<tbody>
		<tr>
			<td><em>attrName</em></td>
			<td><em>Explanation</em></td>
		</tr>
		<tr>
			<td>datumRatio</td>
			<td>This parameter indicates the ratio is calculated based on Width Or Height! Default auto </td>
		</tr>
		<tr>
			<td>widthRatio</td>
			<td>This parameter indicates the proportion of the size Width</td>
		</tr>
		<tr>
			<td>heightRatio</td>
			<td>This parameter indicates the proportion of the size Height</td>
		</tr>
		<tr>
            <td>layoutSquare</td>
            <td>This parameter indicates the proportion of the square</td>
        </tr>
        <tr>
            <td>layoutAspectRatio</td>
            <td>This parameter indicates the proportion of the (width / height)</td>
        </tr>
	</tbody>
</table>

## Implementing View!

 <ul>
   	<li><a href='javascript:'>RatioAbsoluteLayout</a></li>
   	<li><a href='javascript:'>RatioLinearLayout</a></li>
	<li><a href='javascript:'>RatioButton</a></li>
	<li><a href='javascript:'>RatioCheckBox</a></li>
	<li><a href='javascript:'>RatioCheckedTextView</a></li>
	<li><a href='javascript:'>RatioEditText</a></li>
	<li><a href='javascript:'>RatioFrameLayout</a></li>
	<li><a href='javascript:'>RatioGridLayout</a></li>
	<li><a href='javascript:'>RatioImageButton</a></li>
	<li><a href='javascript:'>RatioImageView</a></li>
	<li><a href='javascript:'>RatioProgressBar</a></li>
	<li><a href='javascript:'>RatioRadioButton</a></li>
	<li><a href='javascript:'>RatioRadioGroup</a></li>
	<li><a href='javascript:'>RatioRelativeLayout</a></li>
	<li><a href='javascript:'>RatioSpace</a></li>
	<li><a href='javascript:'>RatioTableLayout</a></li>
	<li><a href='javascript:'>RatioTextView</a></li>
	<li><a href='javascript:'>RatioGridView</a></li>
	<li><a href='javascript:'>RatioListView</a></li>
	<li><a href='javascript:'>RatioRecyclerView</a></li>
	<li><a href='javascript:'>RatioCardView</a></li>
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
        if (mRatioLayoutDelegate != null) {
            mRatioLayoutDelegate.update(widthMeasureSpec, heightMeasureSpec);
            widthMeasureSpec = mRatioLayoutDelegate.getWidthMeasureSpec();
            heightMeasureSpec = mRatioLayoutDelegate.getHeightMeasureSpec();
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    public void setRatio(RatioDatumMode mode, float datumWidth, float datumHeight) {
        if (mRatioLayoutDelegate != null) {
            mRatioLayoutDelegate.setRatio(mode, datumWidth, datumHeight);
        }
    }

    @Override
    public void setSquare(boolean square) {
        if (mRatioLayoutDelegate != null) {
            mRatioLayoutDelegate.setSquare(square);
        }
    }

    @Override
    public void setAspectRatio(float aspectRatio) {
        if (mRatioLayoutDelegate != null) {
            mRatioLayoutDelegate.setAspectRatio(aspectRatio);
        }
    }
}
```

## Maven
	<dependency>
      <groupId>net.soulwolf.widget</groupId>
      <artifactId>ratiolayout</artifactId>
      <version>2.1.0</version>
      <type>pom</type>
    </dependency>
## Gradle
	allprojects {
       repositories {
          jcenter()
       }
	}
	
	compile 'net.soulwolf.widget:ratiolayout:2.1.0'

## Developed by
  Amphiaraus - <a href='javascript:'>amphiarause@gmail.com</a>

## License
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
	
