/*******************************************************************************
 * Copyright (c) 2015 Christos Froussios
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 *******************************************************************************/
package itrx.chapter1;

import java.util.Arrays;

import org.junit.Test;

import rx.observers.TestSubscriber;
import rx.subjects.PublishSubject;

public class PublishSubjectExample {

	@Test
	public void example() {
		PublishSubject<Integer> subject = PublishSubject.create();
		subject.onNext(1);
		subject.subscribe(System.out::println);
		subject.onNext(2);
		subject.onNext(3);
		subject.onNext(4);
		
		// 2
		// 3
		// 4

        /*
        1 не была напечатана из-за того, что мы не были подписаны в момент когда она была передана.
        После того как мы подписались, мы начали получать все значения поступающие в subject.
         */
	}
	
	
	//
	// Test
	//
	
	@Test
	public void test() {
        //for testing purposes
		TestSubscriber<Integer> tester = new TestSubscriber<>();
		
		PublishSubject<Integer> subject = PublishSubject.create();
		subject.onNext(1);
		subject.subscribe(tester);
		subject.onNext(2);
		subject.onNext(3);
		subject.onNext(4);
		
		tester.assertReceivedOnNext(Arrays.asList(2,3,4));
	}

}
