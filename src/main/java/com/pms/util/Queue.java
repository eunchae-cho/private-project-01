package com.pms.util;

import java.util.NoSuchElementException;


public class Queue<E> extends LinkedList<E> implements Cloneable{

	public boolean offer(E e) {
		return add(e);
	}

	public E poll() {
		if (size() == 0) {
			return null;
		}
		return remove(0);
	}

	public E peek() {
		if (size() == 0) {
			return null;
		}
		return get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Queue<E>clone() throws CloneNotSupportedException {
		Queue<E> newQueue = new Queue<>();
		Object[] values = this.toArray();
		for (Object value : values) {
			newQueue.offer((E) value);
		}
		return newQueue;
	}

	@Override
	public Iterator<E> iterator() {

		class QueueIterator<T> implements Iterator<T>{

			Queue<T> queue;

			@SuppressWarnings({ "unchecked", "unused" })
			public QueueIterator() {
				try {
					this.queue = (Queue<T>) Queue.this.clone();
				} catch (Exception e) {
					throw new RuntimeException("큐 복제 중 오류 발생!");
				}
			}

			@Override
			public boolean hasNext() {
				return queue.size() > 0;
			}

			@Override
			public T next() {
				if (queue.size() == 0)
					throw new NoSuchElementException();
				return queue.poll();
			}
		}
		return new QueueIterator<E>();
	}



}
