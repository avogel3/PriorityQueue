class Node 
  def intialize(name, priority)
    @name = name
    @priority = priority
  end
end

class PriorityQueue
  # maintain min heap property
  def intialize
    @queue = []
  end

  def insert(name, priority)
    node = Node.new(name, priority)
    # insert into the queue based on priority
  
  end
end
