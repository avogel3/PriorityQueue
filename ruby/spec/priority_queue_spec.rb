require 'priority_queue'
require 'node'
require 'pry'

RSpec.describe PriorityQueue do
  it { should respond_to(:queue) }

  before :each do
    @queue = PriorityQueue.new
    @queue.insert("Walter", 21)
  end

  describe "#empty?" do
    it "returns truthy if contents are in queue" do
      expect(@queue.empty?).to eq false
    end
  end

  describe "#size" do
    it "should return the size of the backing array" do
      expect(@queue.size).to eq 1
    end
  end

  describe "#insert" do
    it "increments the size of the queue" do
      expect(@queue.size).to eq 1
    end

    it "adds name and priority into the queue" do
      backing_array = @queue.queue
      inserted_node = backing_array.first
      expect(inserted_node.name).to eq "Walter"
      expect(inserted_node.priority).to eq 21
    end

    it "maintains the min heap property" do
      @queue.insert("Matthew", 13)
      @queue.insert("Hermine", 8)
      backing_array = @queue.queue
      min_node = backing_array.first
      expect(min_node.priority).to eq 8
    end
  end

  describe "#remove" do
    it "returns the name of the minimum value from the queue." do
      @queue.insert("Matthew", 13)
      expect(@queue.remove).to eq "Matthew"
    end


    it "removes the value from the queue" do
      @queue.insert("Matthew", 13)
      @queue.remove
      expect(@queue.size).to eq 1
    end

    it "maintains the min heap property" do
      @queue.insert("Matthew", 13)
      @queue.insert("Hermine", 8)
      @queue.insert("Julia", 12)
      @queue.insert("Lisa", 10)
      expect(@queue.remove).to eq "Hermine"
      expect(@queue.remove).to eq "Lisa"
      expect(@queue.remove).to eq "Julia"
      expect(@queue.remove).to eq "Matt"
      expect(@queue.remove).to eq "Walter"
    end
  end
end
