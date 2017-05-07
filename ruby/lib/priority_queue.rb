require_relative 'node'
require 'pry'

class PriorityQueue
  attr_reader :queue

  def initialize
    @queue = Array.new
  end

  def size 
    @queue.size
  end

  def empty?
    size < 1
  end

  def insert(name, priority)
    @queue.push(Node.new(name, priority))
    sift_up
  end

  def remove
    last = size - 1
    swap(0, last)
    min = @queue.pop.name
    sift_down
  end
  

  private
  def sift_up
    if size > 1
      current = size - 1
      begin
        parent = (current - 1) / 2
        if(@queue.at(current).priority < @queue.at(parent).priority) 
          swap(current, parent)
        end
        current -= 1
      end while(current > 0)
    end
  end

  def sift_down
    last = size - 1
    current = 0
    begin
      node = current
      left_child = node*2
      right_child = node*2 + 1

    end while(current < last)
  end

  def swap(from_position, to_position)
    temp = @queue[from_position]
    @queue[from_position] = @queue[to_position]
    @queue[to_position] = temp
  end
end
